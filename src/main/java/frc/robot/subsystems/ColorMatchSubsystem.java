
 /* Copyright (c) 2020 REV Robotics
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of REV Robotics nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 */

package frc.robot.subsystems;
import java.lang.Math;
import java.util.ArrayList;

import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.ColorShim;

public class ColorMatchSubsystem {

    private static double CalculateDistance(Color color1, Color color2) {
        double redDiff = color1.red - color2.red;
        double greenDiff = color1.green - color2.green;
        double blueDiff = color1.blue - color2.blue;

        return Math.sqrt((redDiff*redDiff + greenDiff*greenDiff + blueDiff*blueDiff)/2);
    }
    
    private static final double kDefaultConfidence = 0.95;
    private double m_confidenceLevel;
    private ArrayList<Color> m_colorsToMatch = new ArrayList<Color>();

    public ColorMatchSubsystem() {
        m_confidenceLevel = kDefaultConfidence;
    }

    /**
    // * Add color to match object
    // * 
    // * @param color color to add to matching
    // * 
     */ 
    public void addColorMatch(Color color) {
        m_colorsToMatch.add(color);
    }

    /**
     //* Set the confidence interval for determining color. Defaults to 0.95
     //* 
     //* @param confidence    A value between 0 and 1
     */
    public void setConfidenceThreshold(double confidence) {
        if (confidence < 0) { 
            confidence = 0;
        } else if (confidence > 1) {
            confidence = 1;
        }
        m_confidenceLevel = confidence;
    }

    /**
     //* MatchColor uses euclidean distance to compare a given normalized RGB  
     //* vector against stored values
     //* 
     //* @param colorToMatch color to compare against stored colors
     //* 
     //* @return  Matched color if detected, returns null if no color detected 
     //* confidence level
     */ 
    public ColorMatchResult matchColor(Color colorToMatch) {
        ColorMatchResult match = matchClosestColor(colorToMatch);
        if ( match.confidence > m_confidenceLevel ) {
            return match;
        }
        return null;
    }

    /**
     //* Create an frc.Color object from r g b. This is necessary for WPILib 
     //* versions older than 2020.2.2 and will be deprecated in 2021.
     //* 
     //* @param r Red value
     //* 
     //* @param g Green value
     //* 
     //* @param b Blue value
     //* 
     //* @return  frc.Color object
     */
    public static Color makeColor(double r, double g, double b) {
        return new ColorShim(r, g, b);
    }

     /**
      MatchColor uses euclidean distance to compare a given normalized RGB  
      vector against stored values
      
      @param color color to compare against stored colors
      
      @return  Closest color to match
     */
    public ColorMatchResult matchClosestColor(Color color) {
        double magnitude = color.red + color.blue + color.green;
        if (magnitude > 0 && m_colorsToMatch.size() > 0) {
            double minDistance = 1.0;
            int idx = 0;

            for (int i=0; i < m_colorsToMatch.size(); i++) {
                double targetDistance = CalculateDistance(m_colorsToMatch.get(i), color);

                if (targetDistance < minDistance) {
                    minDistance = targetDistance;
                    idx = i;
                }
            }
            ColorMatchResult match = new ColorMatchResult(m_colorsToMatch.get(idx), 1.0 - (minDistance / magnitude) );
            return match;
        } else {
            //return frc::Color::kBlack;
            return new ColorMatchResult(Color.kBlack, 0.0);
        }
    }

	public void setCPMotorSpeed(double spid) {
  }
  
}
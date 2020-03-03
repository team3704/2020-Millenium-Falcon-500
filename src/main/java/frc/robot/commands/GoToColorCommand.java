// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands;

// import com.revrobotics.ColorMatchResult;

// //import com.revrobotics.ColorMatch;

// import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.util.Color;
// //import frc.robot.subsystems;
// import frc.robot.Robot;


// public class GoToColorCommand extends Command {
//   public GoToColorCommand() {
//     // Use requires() here to declare subsystem dependencies
//     requires(Robot.controlPanelSubsystem);
//     requires(Robot.colorSensorSubsystem);
//     // eg. requires(chassis);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize() {
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   protected void execute() {
//     Robot.controlPanelSubsystem.setCPMotorGSpeed(0.5);
//     Robot.controlPanelSubsystem.setCPMotorRSpeed(0.5);
//     Robot.controlPanelSubsystem.setCPMotorYSpeed(0.5);
//     Robot.controlPanelSubsystem.setCPMotorBSpeed(0.5);
//     //Robot.colorMatchSubsystem.matchColor(ColorMatch.makeColor(0.143, 0.427, 0.429));
//    }
   
//   public void robotPeriodic() {
    
//      // The method GetColor() returns a normalized color value from the sensor and can be
//      // useful if outputting the color to an RGB LED or similar. To
//      // read the raw color, use GetRawColor().
 
//      // The color sensor works best when within a few inches from an object in
//      // well lit conditions (the built in LED is a big help here!). The farther
//      // an object is the more light from the surroundings will bleed into the 
//      // measurements and make it difficult to accurately determine its color.
  
//     Color detectedColor = m_colorSensor.getColor();

//      // Run the color match algorithm on our detected color
     
//     String colorString;
//     ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

//     // the m_ mean that they are supposed to be classes


//    /* if (match.color == kBlueTarget) {
//       colorString = "Blue";
//     } else if (match.color == kRedTarget) {
//       colorString = "Red";
//     } else if (match.color == kGreenTarget) {
//       colorString = "Green";        //nice
//     } else if (match.color == kYellowTarget) {
//       colorString = "Yellow";
//     } else {
//       colorString = "Unknown";
//     } */
//   } 

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   protected boolean isFinished() {
//     return false;
//   }

//   // Called once after isFinished returns true
//   @Override
//   protected void end() {
//   }

//   // Called when another command which requires one or more of the same
//   // subsystems is scheduled to run
//   @Override
//   protected void interrupted() {
//   }
// }

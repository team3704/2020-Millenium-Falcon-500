// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

//  import com.revrobotics.ColorMatch;
//  import com.revrobotics.ColorSensorV3f;
//  import com.revrobotics.ColorMatch;
//  import com.revrobotics.ColorSensorV3;
//  import edu.wpi.first.wpilibj.I2C;

//  import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//  import edu.wpi.first.wpilibj.util.Color;

//  import frc.robot.Robot;
 

 /**
  * Add your docs here.
  */

 public class ControlPanelSubsystem extends Subsystem {
   //    Put methods for controlling this subsystem
   //    here. Call these from Commands.

   // Instantiate new motor controller objects
   public WPI_TalonSRX controlPanelMotor = new WPI_TalonSRX(RobotMap.controlPanelPort);

   // Instantiate new Solenoid for pneumatic cylinder
   public DoubleSolenoid controlPanelSolenoid = new DoubleSolenoid(RobotMap.controlPanelDeploySolenoidPort,RobotMap.controlPanelRetractSolenoidPort);

   public void setCPMSpeed(double speed){
        controlPanelMotor.set(speed);
   }

   public void deployPiston() {
        controlPanelSolenoid.set(Value.kForward);
   }
  
   public void retractPiston() {
        controlPanelSolenoid.set(Value.kReverse);
   }

   @Override
   public void initDefaultCommand() {
   // Set the default command for a subsystem here.
   // setDefaultCommand(new MySpecialCommand());
   }
  }



//   private final I2C.Port i2cPort = I2C.Port.kOnboard;

//   /**
//    * A Rev Color Sensor V3 object is constructed with an I2C port as a 
//    * parameter. The device will be automatically initialized with default 
//    * parameters.
//    */
//   private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

//   /**
//    * A Rev Color Match object is used to register and detect known colors. This can 
//    * be calibrated ahead of time or during operation.
//    * 
//    * This object uses a simple euclidian distance to estimate the closest match
//    * with given confidence range.
//    */
//   private final ColorMatch m_colorMatcher = new ColorMatch();

//   /**
//    * Note: Any example colors should be calibrated as the user needs, these
//    * are here as a basic example.
//    */
//   private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
//   private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
//   private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
//   private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

//     public void robotInit() {
//     m_colorMatcher.addColorMatch(kBlueTarget);
//     m_colorMatcher.addColorMatch(kGreenTarget);
//     m_colorMatcher.addColorMatch(kRedTarget);
//     m_colorMatcher.addColorMatch(kYellowTarget);    
//     }


//   public WPI_TalonSRX CPMotorG = new WPI_TalonSRX(RobotMap.controlPanelPortG);
//   public WPI_TalonSRX CPMotorR = new WPI_TalonSRX(RobotMap.controlPanelPortR);
//   public WPI_TalonSRX CPMotorY = new WPI_TalonSRX(RobotMap.controlPanelPortY);
//   public WPI_TalonSRX CPMotorB = new WPI_TalonSRX(RobotMap.controlPanelPortB); 

//   public void setCPMotorGSpeed(double speed){
//     CPMotorG.set(speed);
//   }  public void setCPMotorBSpeed(double speed){
//     CPMotorB.set(speed);
//   }  public void setCPMotorRSpeed(double speed){
//     CPMotorR.set(speed);
//   }  public void setCPMotorYSpeed(double speed){
//     CPMotorY.set(speed);
//   }

//   public static double CalculateDistance(final Color color1, final Color color2) {
//   double redDiff = color1.red - color2.red;
//   double greenDiff = color1.green - color2.green;
//   double blueDiff = color1.blue - color2.blue;
//   return Math.sqrt((redDiff*redDiff + greenDiff*greenDiff + blueDiff*blueDiff)/2);
  

//   private final I2C.Port i2cPort = I2C.Port.kOnboard;

//   private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

//   private final ColorMatch m_colorMatcher = new ColorMatch();

//   private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
//   private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
//   private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
//   private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

    
//      // Open Smart Dashboard or Shuffleboard to see the color detected by the 
//      // sensor.
     
//     /*SmartDashboard.putNumber("Red", ColorMatchSubsystem.makeColor(r, g, b));      
//     SmartDashboard.putNumber("Green", detectedColor.green);  
//     SmartDashboard.putNumber("Blue", detectedColor.blue);
//     SmartDashboard.putNumber("Confidence", match.confidence);
//     SmartDashboard.putString("Detected Color", colorString);*/


//     // if("color" == "red") {
//     //   wait(1);
//     // }else{
//     //   if("color" == "green"){
//     //     wait(1);
//     //   }else{
//     //     if("color" == "blue"){
//     //       wait(1);
//     //     }
//    }

//     

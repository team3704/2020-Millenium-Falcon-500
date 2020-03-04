// /*----------------------------------------------------------------------------*/                                                                            
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */                                                                                    
// /* Open Source Software - may be modified and shared by FRC teams. The code   */                                                                            
// /* must be accompanied by the FIRST BSD license file in the root directory of */                                                                                    
// /* the project.                                                               */                                                                 
// /*----------------------------------------------------------------------------*/         
package frc.robot;

//import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ArcadeDriveSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ColorMatchSubsystem;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LoaderSubsystem;
import frc.robot.subsystems.MagazineSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.Arcade_ShiftCommand;

 // The VM is configured to automatically run this class, and to call the
 // functions corresponding to each mode, as described in the TimedRobot
 // documentation. If you change the name of this class or the package after
 // creating this project, you must also update the build.gradle file in the
 // project.
 
public class Robot extends TimedRobot {

  // Robot Subsystems
  public static ArcadeDriveSubsystem arcadeDriveSubsystem = new ArcadeDriveSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static MagazineSubsystem magazineSubsystem = new MagazineSubsystem();
  public static LoaderSubsystem loaderSubsystem = new LoaderSubsystem();
  public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public static ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  public static ColorMatchSubsystem colorMatchSubsystem = new ColorMatchSubsystem();
  public static ControlPanelSubsystem controlPanelSubsystem = new ControlPanelSubsystem();
  //public static ColorSensorV3 colorSensor = new ColorSensorV3();
  
  // Operator Inputs
  public static OI oi;

  //Timer Instantiation
  private final Timer timer = new Timer();
  
  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

   // This function is run when the robot is first started up and should be
   // used for any initialization code.
   
  @Override
  public void robotInit() {
    oi = new OI();
    chooser.setDefaultOption("Default Auto", new Arcade_ShiftCommand(Value.kForward));
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", chooser);
  } //nice

   // This function is called every robot packet, no matter the mode. Use
   // this for items like diagnostics that you want ran during disabled,
   // autonomous, teleoperated and test.
   //
   // <p>This runs after the mode specific periodic functions, but before
   // LiveWindow and SmartDashboard integrated updating.
   
  @Override
  public void robotPeriodic() {
  }

   // This function is called once each time the robot enters Disabled mode.
   // You can use it to reset any subsystem information you want to clear when
   // the robot is disabled.
   
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

   // This autonomous (along with the chooser code above) shows how to select
   // between different autonomous modes using the dashboard. The sendable
   // chooser code works with the Java SmartDashboard. If you prefer the
   // LabVIEW Dashboard, remove all of the chooser code and uncomment the
   // getString code to get the auto name from the text box below the Gyro
   //
   // <p>You can add additional auto modes by adding additional commands to the
   // chooser code above (like the commented example) or additional comparisons
   // to the switch structure below with additional strings & commands.

  @Override
  public void autonomousInit() {
    timer.reset();
    timer.start();
    autonomousCommand = chooser.getSelected();

     // String autoSelected = SmartDashboard.getString("Auto Selector",
     // "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     // = new MyAutoCommand(); break; case "Default Auto": default:
     // autonomousCommand = new ExampleCommand(); break; }

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

   // This function is called periodically during autonomous.

  @Override
  public void autonomousPeriodic() {

    //Drive for 2 seconds
    if (timer.get() < 2.0) {
      Robot.arcadeDriveSubsystem.manualArcadeDrive(0.5, 0.0);
    } else {
      Robot.arcadeDriveSubsystem.drive.stopMotor(); // stops robot
    }
    
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

   // This function is called periodically during operator control.
  
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

   // This function is called periodically during test mode.

  @Override
  public void testPeriodic() {
  }
}

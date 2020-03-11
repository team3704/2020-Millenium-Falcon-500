/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Arcade_ShiftCommand;

/**
 * Add your docs here.
 */
public class ArcadeDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Instantiate new motor controller objects
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public WPI_TalonSRX leftSlave1 = new WPI_TalonSRX(RobotMap.leftSlavePort);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX rightSlave1 = new WPI_TalonSRX(RobotMap.righSlavePort);


  // Instantiate new gearbox Solenoid
  private final DoubleSolenoid shiftSolenoid = new DoubleSolenoid(RobotMap.GBSlowSolenoidPort, RobotMap.GBFastSolenoidPort);

  // Instantiate a new DifferentialDrive objects
  public DifferentialDrive drive = null;
  

  // Create constructor Function
  public ArcadeDriveSubsystem() {
      // Point slaves to masters
      leftSlave1.follow(leftMaster);
      rightSlave1.follow(rightMaster);

      drive = new DifferentialDrive(leftMaster, rightMaster);
      drive.setSafetyEnabled(false);

      //Set neutral mode to allow drive train motors to coast when no power is applied
      leftMaster.setNeutralMode(NeutralMode.Coast);
      leftSlave1.setNeutralMode(NeutralMode.Coast);
      rightMaster.setNeutralMode(NeutralMode.Coast);
      rightSlave1.setNeutralMode(NeutralMode.Coast);

  }

  // Add manualArcadeDrive() method
  public void manualArcadeDrive(double move, double turn, boolean squareInputs) {
    
    // Max speed for testing mode
    // if(move > 0.75) move = .75;
    // if(move < -0.75) move = -.75;
    // if(turn > 0.25) move = .25;
    // if(turn < -0.25) move = -.25;

    // Creates deadband for small joystick movements
    //if (Math.abs(move) < 0.05) {
    //  move = 0;
    //}
    //if (Math.abs(turn) < 0.05) {
    //  turn = 0;
   // }

    //Decrease performance to improve driver control
    move *= 0.75;
    turn *= 0.75;
    squareInputs = true;

    drive.arcadeDrive(move, turn, squareInputs);; 

  }

    public void stop(){
          drive.arcadeDrive(0, 0);
    }

    public void shift(Value value){
         shiftSolenoid.set(value);
    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Arcade_ShiftCommand(Value.kForward));
  }


  
}

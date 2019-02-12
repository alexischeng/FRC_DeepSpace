package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.MapKeys;



/**
 * Add your docs here.
 */
public class LiftSubsystem extends Subsystem {
  private WPI_TalonSRX m_motorup1;
  private WPI_TalonSRX m_motorup2;
  private SpeedControllerGroup m_lift;

  public LiftSubsystem(){
    m_motorup1 = new WPI_TalonSRX(Robot.m_map.getId(MapKeys.LIFT_LEFT));
    m_motorup1.set(ControlMode.PercentOutput, 0.0);
    m_motorup2 = new WPI_TalonSRX(Robot.m_map.getId(MapKeys.LIFT_RIGHT));
    m_motorup2.set(ControlMode.PercentOutput,0.0);
    
    m_lift = new SpeedControllerGroup(m_motorup1, m_motorup2);
  
  }


  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
     
  }

  public void update(double x) {
    m_lift.set(x);
  }

  
} 
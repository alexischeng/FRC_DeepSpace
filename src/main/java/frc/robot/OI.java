package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;





public class OI{


  Joystick joy = new Joystick(0);
  
  private final int CAMERA_BUTTON = 2;
  private final int Lvl2DESC_BUTTON = 7;
  private final int Lvl2CLIMB_BUTTON = 8;
  private final int Lvl3CLIMB_BUTTON = 3;
  private final int CLIMBNEXT_BUTTON = 6;
  private final int CLIMBPREV_BUTTON = 5;
  public JoystickButton bButton1 = new JoystickButton(joy, CAMERA_BUTTON);
	public JoystickButton backButton1 = new JoystickButton(joy, Lvl2DESC_BUTTON);
  public JoystickButton startButton1 = new JoystickButton(joy, Lvl2CLIMB_BUTTON);
  public JoystickButton xButton1 = new JoystickButton(joy, Lvl3CLIMB_BUTTON);
  public JoystickButton leftBumper1 = new JoystickButton(joy, CLIMBPREV_BUTTON);
  public JoystickButton rightBumper1 = new JoystickButton(joy, CLIMBNEXT_BUTTON);
    
  Joystick joy2 = new Joystick(1);


  private final int HIGHHATCH_BUTTON = 4;
  private final int MIDHATCH_BUTTON = 3;
  private final int LOWHATCH_BUTTON = 1;
  private final int CLAMP_BUTTON = 2;

  public JoystickButton yButton2 = new JoystickButton(joy2, HIGHHATCH_BUTTON);
  public JoystickButton xButton2 = new JoystickButton(joy2, MIDHATCH_BUTTON);
  public JoystickButton aButton2 = new JoystickButton(joy2, LOWHATCH_BUTTON);
  public JoystickButton bButton2 = new JoystickButton(joy2, CLAMP_BUTTON);



  public OI () {

   // bButton1.toggleWhenPressed(new CameraToggle);

    /*rightTrigger2.togglewhenActive(new SlideCommand()); //slide moves right
    rightTrigger2.whenInactive(new SlideCommand()); //slide stops at current place

    leftTrigger2.togglewhenActive(new SlideCommand()); //slide moves left
    leftTrigger2.whenInactive(new SlideStop()); //slide stops at current place
*/
    backButton1.whenPressed(new DescendCommandGroup()); //initiate lvl 2 descent
    startButton1.whenPressed(new L2AscendCommandGroup()); //initiate lvl 2 climb
    xButton1.whenPressed(new L3AscendCommandGroup()); // intiate lvl 3 climb

    leftBumper1.whenPressed(new ClimbPrevCommand());
    rightBumper1.whenPressed(new ClimbNextCommand());
    
    yButton2.toggleWhenPressed(new LiftCommand()); //move lift to high hatch position
    xButton2.toggleWhenPressed(new LiftCommand()); //move lift to mid hatch position
    aButton2.toggleWhenPressed(new LiftCommand()); //move lift to low hatch position

    bButton2.whenActive(new GrabberExtend()); //toggle for clamp
    bButton2.whenInactive(new GrabberRetract()); //toggle for clamp
    

    SmartDashboard.putNumber("Joy1 Axis 1", joy.getRawAxis(1));
    SmartDashboard.putNumber("Joy1 Axis 2", joy.getRawAxis(4));
    SmartDashboard.putBoolean("Level 2 Descend Active", joy.getRawButtonPressed(Lvl2DESC_BUTTON)); //we wanted this as a drop down list....?
    SmartDashboard.putBoolean("Level 2 Ascend Active", joy.getRawButtonPressed(Lvl2CLIMB_BUTTON));
    SmartDashboard.putBoolean("Level 3 Ascend", joy.getRawButtonPressed(Lvl3CLIMB_BUTTON));
 
    //change file
  }
 



  public double getForwardValue() {
    return joy.getRawAxis(1);

  }
  public double getTurnValue() {
    return joy.getRawAxis(4);
  }

  public double getLiftValue() {
    return joy2.getRawAxis(1);
  }

  public double getSlideValue() {
    return joy2.getRawAxis(3) - joy2.getRawAxis(2);
  }


  


}

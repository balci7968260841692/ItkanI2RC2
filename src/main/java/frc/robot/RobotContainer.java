package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DistanceAuto;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TimedAuto;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final static DriveTrain drive = new DriveTrain();
  private final static TimedAuto timedAuto = new TimedAuto();
  private static Joystick joy1;
  private static Joystick joy2;
  private final DriveTrain _driveTrain;
  private final Joystick _leftJoystick;
  private final Joystick _rightJoystick;
  //private final TankDrive _tankDrive;
  private final Command _distanceAuto;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    _driveTrain = new DriveTrain();
    _leftJoystick = new Joystick(Constants.joy1);
    _rightJoystick = new Joystick(Constants.joy2);
    //_tankDrive = new TankDrive(_driveTrain,_leftJoystick,_rightJoystick);
    _distanceAuto = new DistanceAuto(_driveTrain,1);
    //_driveTrain.setDefaultCommand(_distanceAuto);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return _distanceAuto;
  }
  public static Joystick getJoy1(){
    return joy1;
  }
  public static Joystick getJoy2(){
    return joy2;
  }
  public static DriveTrain getDrive(){
    return drive;
  }
}

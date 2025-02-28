package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;



public class TimedAuto extends CommandBase {
  private final Timer timer = new Timer();
private final DriveTrain drive = new DriveTrain();
 
  /** Creates a new TimedAuto. */
  public TimedAuto() {
    // Use addRequirements() here to declare subsystem dependencies.
 
    timer.reset();
    addRequirements(drive);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get()<2){
      drive.tankDrive(0.3,0.3);
    }else if(timer.get()<3){
      drive.tankDrive(-0.3, -0.3);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get()>3){
      return true;
    }
    return false;
  }
}


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DistanceAuto extends CommandBase{
    private final DriveTrain _driveTrain;
    private double pos; 
    public DistanceAuto(DriveTrain dt, double pos){
        _driveTrain = dt;
        this.pos = pos;
        addRequirements(dt);
    }
 
public void initialize(){
    _driveTrain.resetEncoders();
}
public void execute() {
    if(_driveTrain.getPos() < pos){
        _driveTrain.tankDrive(0.6,0.6);
        
    }else{
        _driveTrain.tankDrive(0,0);
    }
}
@Override
public boolean isFinished(){
    if(_driveTrain.getPos()<pos){
        return false;
    }
    return true;
}
}
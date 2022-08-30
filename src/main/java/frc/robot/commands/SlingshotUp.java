// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Slingshot;

public class SlingshotUp extends CommandBase {
  Slingshot m_slingshot;

  /** Creates a new SlingshotUp. */
  public SlingshotUp(Slingshot slingshot) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_slingshot = slingshot;
    addRequirements(slingshot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_slingshot.setSpeed(-0.75);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_slingshot.setSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_slingshot.reverseLimit();
  }
}

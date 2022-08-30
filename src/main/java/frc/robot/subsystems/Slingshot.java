// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch.Type;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Slingshot extends SubsystemBase {
  CANSparkMax slingshot_motor = new CANSparkMax(7, MotorType.kBrushless);

  /** Creates a new Slingshot. */
  public Slingshot() {
  }

  public boolean forwardLimit() {
    return slingshot_motor.getForwardLimitSwitch(Type.kNormallyClosed).isPressed();
  }

  public boolean reverseLimit() {
    return slingshot_motor.getReverseLimitSwitch(Type.kNormallyClosed).isPressed();
  }

  public void setSpeed(double v) {
    slingshot_motor.set(v);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Slingshot/Forward Limit", forwardLimit());
    SmartDashboard.putBoolean("Slingshot/Reverse Limit", reverseLimit());
    // This method will be called once per scheduler run
  }
}

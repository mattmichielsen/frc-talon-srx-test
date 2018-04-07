package org.usfirst.frc.team85.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Robot extends IterativeRobot {

	private TalonSRX _talon;
	private Joystick _joystick;
	
	@Override
	public void robotInit() {
		_talon = new TalonSRX(12);
		_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 20);
		_talon.setSelectedSensorPosition(0, 0, 0);
		_talon.selectProfileSlot(0, 0);
		_joystick = new Joystick(0);
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		System.out.println("Encoder value: " + _talon.getSelectedSensorPosition(0));
		_talon.set(ControlMode.PercentOutput, _joystick.getRawAxis(0));
	}
}

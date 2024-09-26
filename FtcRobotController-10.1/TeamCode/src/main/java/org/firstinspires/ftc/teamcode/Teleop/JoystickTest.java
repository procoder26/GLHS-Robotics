package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Servo Button Control", group="Linear OpMode")
public class JoystickTest extends LinearOpMode {

    // Declare servo variable
    private Servo myServo;

    // Track the current position (0 = 0 degrees, 1 = 180 degrees)
    private boolean isAt180 = false;

    @Override
    public void runOpMode() {

        // Initialize the servo (on port 0)
        myServo = hardwareMap.get(Servo.class, "servo0");

        // Set initial position to 0 (0 degrees)
        myServo.setPosition(0.0);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {
            // Check if the A button is pressed
            if (gamepad1.a) {
                // Toggle between 0 and 180 degrees
                if (isAt180) {
                    myServo.setPosition(0.0);  // Move to 0 degrees
                } else {
                    myServo.setPosition(1.0);  // Move to 180 degrees
                }

                // Toggle the position tracker
                isAt180 = !isAt180;

                // Add a small delay to prevent multiple triggers from one button press
                sleep(500);
            }

            // Display the servo position for debugging
            telemetry.addData("Servo Position", myServo.getPosition());
            telemetry.update();
        }
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="9377 oWo")
public class mecanum9377 extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor rearLeft;
    DcMotor rearRight;
    DcMotor rightSpin;
    DcMotor leftSpin;
    DcMotor chainDrive;
    DcMotor arm;
    Servo grabbyL;
    Servo grabbyR;
    //DcMotor chain;
    double contpower;
    double contpower2;
    //Servo marker

    //ColorSensor color;
    //DistanceSensor dist;

    boolean brakeToggle = false;

    @Override
    public void init() {

        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        rearLeft = hardwareMap.dcMotor.get("rearLeft");
        rearRight = hardwareMap.dcMotor.get("rearRight");
        arm = hardwareMap.dcMotor.get("arm");
        grabbyL = hardwareMap.get(Servo.class,"grabbyL");
        chainDrive = hardwareMap.dcMotor.get("chainDrive");

       // chain = hardwareMap.dcMotor.get("chain");
//
        grabbyR = hardwareMap.get(Servo.class, "grabbyR");

        grabbyR.setPosition(1);
        grabbyL.setPosition(1);
        rightSpin = hardwareMap.dcMotor.get("rightSpin");
      leftSpin = hardwareMap.dcMotor.get("leftSpin");

        // marker = hardwareMap.servo.get("marker");

        //arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //color = hardwareMap.colorSensor.get("color");
        // dist = hardwareMap.get(DistanceSensor.class, "dist");

        // We show the log in oldest-to-newest order, as that's better for poetry
        telemetry.log().setDisplayOrder(Telemetry.Log.DisplayOrder.OLDEST_FIRST);
        // We can control the number of lines shown in the log
        telemetry.log().setCapacity(7);

    }

    @Override
    public void loop() {

        // telemetry.addData("Red", color.red());
        //telemetry.addData("Green", color.green());
        //telemetry.addData("Blue", color.blue());
        // telemetry.addData("Dist", dist.getDistance(DistanceUnit.CM));
        //telemetry.update();

        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;


if (gamepad2.left_bumper)
{
    grabbyL.setPosition(1);
    grabbyR.setPosition(1);

}

else
{
    grabbyL.setPosition(0);
    grabbyR.setPosition(0);
}

if(gamepad2.left_trigger > 0)
{
    rightSpin.setPower(gamepad2.left_trigger);
    leftSpin.setPower(-gamepad2.left_trigger);

        }

        if(gamepad2.right_trigger > 0)
        {
            rightSpin.setPower(-gamepad2.left_trigger);
            leftSpin.setPower(gamepad2.left_trigger);

        }



        frontLeft.setPower( turn - forward - strafe);
        frontRight.setPower(turn + forward - strafe);
        rearLeft.setPower(  turn - forward + strafe);
        chainDrive.setPower(gamepad2.left_stick_y);
        rearRight.setPower( turn + forward + strafe);
        arm.setPower(gamepad2.right_stick_y);

        //chain.setPower(gamepad2.);

       
       

        // arm.setPower(gamepad2.left_stick_y);

        /* NOTES

         */

    }


}

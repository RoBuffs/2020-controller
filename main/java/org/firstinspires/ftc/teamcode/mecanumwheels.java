package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp(name="hubert :3")
public class mecanumwheels extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor rearLeft;
    DcMotor rearRight;
    DcMotor rightSpin;
    DcMotor leftSpin;
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

       // chain = hardwareMap.dcMotor.get("chain");
//
        grabbyR = hardwareMap.get(Servo.class, "grabbyR");

        grabbyR.setPosition(0);
        grabbyL.setPosition(1);
       // rightSpin = hardwareMap.dcMotor.get("rightSpin");
      // leftSpin = hardwareMap.dcMotor.get("leftSpin");

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




        frontLeft.setPower( turn - forward - strafe);
        frontRight.setPower(turn + forward - strafe);
        rearLeft.setPower(  turn - forward + strafe);
        rearRight.setPower( turn + forward + strafe);
        arm.setPower(gamepad2.right_stick_y);

        //chain.setPower(gamepad2.);


        // arm.setPower(gamepad2.left_stick_y);

        /* NOTES

         */

    }


}


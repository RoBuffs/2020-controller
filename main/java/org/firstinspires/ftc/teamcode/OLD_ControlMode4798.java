package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "OLD_4798", group = "Competition")
public class OLD_ControlMode4798 extends OpMode {

    //Initialize Motor Variables
    DcMotor left;
    DcMotor right;

    DcMotor arm;

    Servo leftClaw;
    Servo rightClaw;

    @Override
    public void init(){
        //get references to the motors from hardware map
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

        arm = hardwareMap.dcMotor.get("arm");
        leftClaw = hardwareMap.servo.get("sleft");
        rightClaw = hardwareMap.servo.get("sright");

        // We show the log in oldest-to-newest order, as that's better for poetry
        telemetry.log().setDisplayOrder(Telemetry.Log.DisplayOrder.OLDEST_FIRST);
        // We can control the number of lines shown in the log
        telemetry.log().setCapacity(6);

    }
    @Override
    public void loop(){

        //get controller values
        float leftY1 = gamepad1.left_stick_y;
        float rightY1 = gamepad1.right_stick_y;

        float leftY2 = gamepad2.left_stick_y;

        if(gamepad2.left_bumper){

            rightClaw.setPosition(0);
            leftClaw.setPosition(1.0);

        }else{

            rightClaw.setPosition(1.0);
            leftClaw.setPosition(0);

        }



        //set motors w/ value
        left.setPower(leftY1);
        right.setPower(-rightY1);
        arm.setPower(leftY2);

    }

}

class Robot{

    //motor is a variable
    //The type of variable is Motor, a custom type made by the Motor.java file
    private Arm arm;

    //Constructor of Robot
    //This is called when a Robot object is created
    public Robot(){
        arm = new Arm();
    }

    //A function to call the move function in the motor class
    public void moveArm(){
        arm.moveMotor();
    }
    
}
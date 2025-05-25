package Utils;

public class CommonScenario {

    public CommonScenario(){
        ExtentTestManager.initializeReporter("Test_"+this.getClass().getSimpleName());
        ExtentTestManager.generateHTML();
    }
    
    

    
}

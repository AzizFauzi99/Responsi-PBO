
import Controller.AslabController;
import Model.AslabModel;
import View.AslabView;


public class Main {
    public static void main(String[] args) {
        AslabView av = new AslabView();
        av.dispose();
        AslabModel am = new AslabModel();
        AslabController ac = new AslabController(av, am);
    }
}

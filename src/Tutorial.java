import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;


public class Tutorial {

	private static Rengine re = null;
	
	public static void main(String[] args) {
		System.out.println("Creating Rengine (with arguments)");
        String[] Rargs = {"--vanilla"};
        re = new Rengine(Rargs, false, null);
        System.out.println("Rengine created, waiting for R");

        if (!re.waitForR()) {
             System.out.println("Cannot load R");
	return;
        }

        REXP rn = re.eval("rnorm(4)");
        double[] rnd = rn.asDoubleArray();

        for(int i=0; i<rnd.length; i++){
             System.out.print(rnd[i] + " ");
        }
        System.out.println();

        re.end();
        System.out.println("Bye.");
	}

}

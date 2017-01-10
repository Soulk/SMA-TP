package Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MyColor {
	 Jaune,
	 Rouge,
	 Bleu,
	 Vert;
	
	private static final List<MyColor> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
	
	public static MyColor randomColor()  {
	    return VALUES.get(RANDOM.nextInt(SIZE));
	  }
}

package android.graphics;

import android.content.res.AssetManager;
import android_svg_code_render.AndroidClass;
import android_svg_code_render.Initializer;
import android_svg_code_render.OutputBuilder;

/**
 * Created by racs on 2015.03.17..
 */
public class Typeface implements AndroidClass {
    public static final Typeface DEFAULT = new Typeface("Typeface.DEFAULT");
    public static final Typeface SERIF = new Typeface("Typeface.SERIF");
    public static final Typeface SANS_SERIF = new Typeface("Typeface.SANS_SERIF");
    public static final Typeface MONOSPACE = new Typeface("Typeface.MONOSPACE");

    public static final int NORMAL = 0;
    public static final int BOLD = 1;
    public static final int ITALIC = 2;
    public static final int BOLD_ITALIC = 3;
    private static int[] styleValues = {NORMAL, BOLD, ITALIC};
    private static String[] styleNames = {"NORMAL", "BOLD", "ITALIC"};
    private String mInstanceName;

    public Typeface(String instanceName) {
        mInstanceName = instanceName;
    }

    public static Typeface createFromAsset(AssetManager assetManager, String s) {
        throw new RuntimeException("Dummy function");
    }

    public static Typeface create(Typeface family, int typefaceStyle) {
        Typeface newTypeface = new Typeface(Initializer.generateInstanceName(Typeface.class));

        OutputBuilder.addImport(Typeface.class);

        String styleFlags = OutputBuilder.splitFlags(typefaceStyle, "Typeface.", styleValues, styleNames);
        OutputBuilder.append("Typeface %s = Typeface.create(%s, %s);", newTypeface.mInstanceName, family.getInstanceName(), styleFlags);

        return newTypeface;

    }

    @Override
    public String getInstanceName() {
        return mInstanceName;
    }

    @Override
    public void setInstanceName(String instanceName) {
        mInstanceName = instanceName;
    }
}
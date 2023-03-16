package Kartoha_Engine2D.utils;

public final class FloatComparator {

    private final static float epsilon = 0.001f;

    public static boolean equals(float a, float b){
        return (Math.abs(a - b) < epsilon);
    }
}

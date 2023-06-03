package hus.oop.midterm.vectors;

import java.util.Arrays;

public abstract class AbstractMyVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     *
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        double[] data = Arrays.copyOf(coordinates(), size());
        return Arrays.toString(data).replaceAll(",", " ");
    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng số chiều và có tọa độ bằng nhau.
     *
     * @param another
     * @return
     */
    @Override
    public boolean equals(MyVector another) {
        /* TODO */
        if (coordinates().length != another.size()) {
            return false;
        }
        for (int i = 0; i < coordinates().length; i++) {
            if (coordinate(i) != another.coordinate(i)) {
                return false;
            }
        }
        return true;
    }
}

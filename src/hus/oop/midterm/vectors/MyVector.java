package hus.oop.midterm.vectors;

public interface MyVector {
    /**
     * Lấy số chiều của vector.
     * @return
     */
    int size();

    /**
     * Lấy giá trị tọa độ trên trục tọa độ thứ index.
     * @param index
     * @return
     */
    double coordinate(int index);

    /**
     * Lấy tọa độ của vector
     * @return
     */
    double[] coordinates();

    /**
     * Thay đổi giá trị tọa độ trên trục tọa độ index.
     * @param value
     * @param index
     */
    void set(double value, int index);

    /**
     * Lấy chuẩn của vector.
     * @return chuẩn của vector.
     */
    double norm();

    /**
     * So sánh hai vector có bằng nhau không.
     * @param another
     * @return
     */
    boolean equals(MyVector another);
}

package hus.oop.midterm.vectors;

import java.util.*;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        /* TODO */
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        double[] coordi = new double[data.size()];
        for (int i = 0; i < coordi.length; i++) {
            coordi[i] = data.get(i);
        }
        return coordi;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data.add(index, value);
        data.remove(index - 1);
    }

    /**
     * Cộng các giá trị tọa độ với value.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector add(double value) {
        /* TODO */
        double[] result = coordinates();
        for (int i = 0; i < result.length; i++) {
            data.set(i, Math.round((result[i] + value) * 10) / 10.0);
        }
        return this;
    }

    /**
     * Cộng vector khác vào vector hiện tại.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector add(MyListVector another) {
        /* TODO */
        if (size() != another.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        double[] result = coordinates();
        for (int i = 0; i < result.length; i++) {
            data.set(i, Math.round((result[i] + another.coordinate(i)) * 10) / 10.0);
        }
        return this;
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
     *
     * @return vector hiện tại.
     */
    public MyListVector minus(double value) {
        /* TODO */
        double[] result = coordinates();
        for (int i = 0; i < result.length; i++) {
            data.set(i, Math.round((result[i] - value) * 10) / 10.0);
        }
        return this;
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public MyListVector minus(MyListVector another) {
        /* TODO */
        if (size() != another.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        double[] result = coordinates();
        for (int i = 0; i < result.length; i++) {
            data.set(i, Math.round((result[i] - another.coordinate(i)) * 10) / 10.0);
        }
        return this;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public double dot(MyListVector another) throws Exception {
        /* TODO */
        double dot = 0;
        if (size() != another.size()) {
            throw new Exception("Different size");
        }
        for (int i = 0; i < size(); i++) {
            dot += data.get(i) * another.coordinate(i);
        }
        return Math.round(dot * 100) / 100.0;
    }

    /**
     * Các giá trị của vector được lấy mũ power.
     *
     * @param power
     * @return vector hiện tại.
     */
    public MyListVector pow(double power) {
        /* TODO */
        double[] result = coordinates();
        for (int i = 0; i < result.length; i++) {
            data.set(i, Math.pow(result[i], power));
            data.set(i, Math.round(data.get(i) * 100) / 100.0);
        }
        return this;
    }

    /**
     * Các giá trị tọa độ của vector được nhân với value.
     *
     * @return vector hiện tại.
     */
    public MyListVector scale(double value) {
        /* TODO */
        double[] result = coordinates();
        for (int i = 0; i < result.length; i++) {
            data.set(i, result[i] * value);
            data.set(i, Math.round(data.get(i) * 100) / 100.0);
        }
        return this;
    }

    /**
     * Lấy chuẩn của vector.
     *
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        /* TODO */
        double sum = 0;
        double[] data = coordinates();
        for (double datum : data) {
            sum += Math.abs(datum);
        }
        return Math.round(sum * 10) / 10.0;
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        /* TODO */
        data.add(value);
        return this;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     *
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        /* TODO */
        data.add(index, value);
        return this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     *
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector remove(int index) {
        /* TODO */
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return MyListVector.this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các giá trị tọa độ
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     *
     * @param indices
     * @return vector mới có tọa độ được trích xuất từ vector hiện tại.
     */
    public MyListVector extract(int[] indices) throws Exception {
        /* TODO */
        MyListVector subVector = new MyListVector();
        for (int index : indices) {
            if (index <= 0) {
                throw new Exception("Invalid index value");
            }
            if (data.size() > index) {
                subVector.insert(data.get(index - 1));
            } else {
                throw new Exception("Unidentified subspace");
            }
        }
        return subVector;
    }
}

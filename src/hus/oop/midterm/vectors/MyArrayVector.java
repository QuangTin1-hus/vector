package hus.oop.midterm.vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayVector extends AbstractMyVector {
    private static final int DEFAULT_CAPACITY = 1;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        /* TODO */
        data = new double[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        if (size() >= data.length) {
            return null;
        }
        return data;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[index] = value;
    }

    /**
     * Cộng các giá trị tọa độ với value.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyArrayVector add(double value) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            data[i] += value;
            data[i] = Math.round(data[i] * 10) / 10.0;
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
    public MyArrayVector add(MyArrayVector another) {
        /* TODO */
        if (size() != another.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < size(); i++) {
            data[i] += another.coordinate(i);
            data[i] = Math.round(data[i] * 10) / 10.0;
        }
        return this;
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector minus(double value) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            data[i] -= value;
            data[i] = Math.round(data[i] * 10) / 10.0;
        }
        return MyArrayVector.this;
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return
     */
    public MyArrayVector minus() {
        /* TODO */
        return null;
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector minus(MyArrayVector another) {
        /* TODO */
        if (equals(another)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < another.size; i++) {
            data[i] -= another.coordinate(i);
            data[i] = Math.round(data[i] * 10) / 10.0;
        }
        return MyArrayVector.this;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public double dot(MyArrayVector another) {
        double result = 0;
        try {
            for (int i = 0; i < size; i++) {
                result += data[i] * another.coordinate(i);
            }
        } catch (Exception e) {
            System.out.println("Different size");
        }
        return Math.round(result * 100) / 100.0;
    }

    /**
     * Các giá trị của vector được lấy mũ power.
     *
     * @param power
     * @return vector hiện tại.
     */
    public MyArrayVector pow(double power) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            data[i] = Math.pow(data[i], power);
            data[i] = Math.round(data[i] * 100) / 100.0;
        }
        return MyArrayVector.this;
    }

    /**
     * Các giá trị tọa độ của vector được nhân với value.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector scale(double value) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            data[i] *= value;
            data[i] = Math.round(data[i] * 100) / 100.0;
        }
        return MyArrayVector.this;
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
        for (int i = 0; i < data.length; i++) {
            sum += Math.abs(data[i]);
        }
        return Math.round(sum * 10) / 10.0;
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyArrayVector insert(double value) {
        /* TODO */
        return insert(value, size);
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
     *
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector insert(double value, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            System.out.println("Can't insert value at index " + index + "!");
            return null;
        }
        if (size >= data.length - 1) {
            enlarge();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return MyArrayVector.this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     *
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector remove(int index) {
        /* TODO */
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return MyArrayVector.this;
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
    public MyArrayVector extract(int[] indices) throws Exception {
        /* TODO */
        MyArrayVector subVector = new MyArrayVector();
        for (int index : indices) {
            if (index <= 0) {
                throw new Exception("Invalid index value");
            }
            if (data.length > index) {
                subVector.insert(data[index - 1]);
            } else {
                throw new Exception("Unidentified subspace");
            }
        }
        return subVector;
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     *
     * @return vector hiện tại.
     */
    private MyArrayVector enlarge() {
        /* TODO */
        data = Arrays.copyOf(data, data.length * 2);
        return this;
    }
}

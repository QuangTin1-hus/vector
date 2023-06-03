package hus.oop.midterm.vectors;

import java.util.*;

public class BasicStatistics {
    private MyVector[] vectors;

    protected static Random random = new Random();


    public static void main(String[] args) throws Exception {
        /*
         TODO

         Thực hiện các yêu cầu sau.

         I. Test chức năng vector
           - Viết các hàm testArrayVector để test các chứ năng của array vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...
           - Viết các hàm testListVector để test các chứ năng của list vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...

         II. Thực hiện thống kê đơn giản với các vector
           - Tạo ra ít nhất 10 vector và cho vào mảng vectors để quản lý. Trong đó có ít nhất 2 nhóm các vector
             có chuẩn bằng nhau.
           - Tìm và in ra thông tin chuẩn nhó nhất, chuẩn lớn nhất của các vector.
           - In ra các vector có chuẩn sắp xếp theo thứ tự tăng dần, giản dần.
           - In ra các vector có chuẩn nằm trong một đoạn [a, b] cho trước.
           - In ra rank của các vector theo thứ tự trong mảng vectors.

         III. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
              (ví dụ NguyenVanA_123456_Vector.txt) và nộp cùng source code.
         */
        System.out.println("ArrayVector");
        testArrayVector();
        System.out.println("\n ListVector");
        testListVector();

        System.out.println("\nStatistic vector");
        BasicStatistics basicStatistics = new BasicStatistics();
        basicStatistics.doSimpleStatic();
    }

    //Tạo các arrayVector với kích thước 5 phần tử
    private static MyArrayVector createRandomArrayVector() {
        MyArrayVector myVector = new MyArrayVector();
        int dimension = 5;
        for (int i = 0; i < dimension; i++) {
            double value = random.nextDouble(5);
            value = Math.round(value * 10) / 10.0;
            myVector.insert(value);
        }
        return myVector;
    }

    private static MyListVector createRandomListVector() {
        MyListVector myVector = new MyListVector();
        int dimension = 5;
        for (int i = 0; i < dimension; i++) {
            double value = random.nextInt(5);
            value = Math.round(value * 10) / 10.0;
            myVector.insert(value);
        }
        return myVector;
    }

    public static void testArrayVector() throws Exception {
        /* TODO */
        MyArrayVector vector1 = createRandomArrayVector();
        vector1.insert(1.0);
        vector1.insert(2.0);
        vector1.insert(3.0, 2);
        //In vector
        System.out.println("MyVector1: " + vector1);
        //Giá trị chuẩn
        System.out.println("norm: " + vector1.norm());
        //Phần tử thứ index
        System.out.println("coordinate index: " + vector1.coordinate(2));
        System.out.println("Calculate vector");
        System.out.println("add value: " + vector1.add(3.0));
        System.out.println("minus value: " + vector1.minus(3.0));
        System.out.println("scale: " + vector1.scale(2.0));
        System.out.println("pow: " + vector1.pow(2.0));
        System.out.println("remove: " + vector1.remove(2));
        System.out.println("MyVector1 after change:" + vector1);

        MyArrayVector vector2 = createRandomArrayVector();
        vector2.insert(4.0, 4);
        vector2.insert(2.0, 1);
        //Cộng trừ hai vector
        System.out.println("\nMyVector2: " + vector2);
        System.out.println("add vector: " + vector2.add(vector1));
        System.out.println("minus vector: " + vector2.minus(vector1));
        System.out.println("dot: " + vector1.dot(vector2));
        int[] subspace = {4, 1};
        System.out.println("MyVector2: " + vector2);
        System.out.println("extract vector: " + vector2.extract(subspace));
    }

    public static void testListVector() throws Exception {
        /* TODO */
        MyListVector vector1 = createRandomListVector();
        vector1.insert(4.0);
        vector1.insert(2.0, 1);
        vector1.insert(2.5);
        System.out.println("MyVector1: " + vector1);
        //Giá trị chuẩn
        System.out.println("norm: " + vector1.norm());
        //Phần tử thứ index
        System.out.println("coordinate index: " + vector1.coordinate(2));
        System.out.println("Calculate vector");
        System.out.println("add value: " + vector1.add(4.0));
        System.out.println("minus value: " + vector1.minus(4.0));
        System.out.println("scale: " + vector1.scale(3.0));
        System.out.println("pow: " + vector1.pow(2.0));
        System.out.println("remove: " + vector1.remove(4));
        System.out.println("MyVector1 after change:" + vector1);

        MyListVector vector2 = createRandomListVector();
        vector2.insert(3, 1);
        vector2.insert(1, 2);
        vector2.insert(4, 3);
        //Cộng trừ hai vector
        System.out.println("\nMyVector2: " + vector2);
        System.out.println("add vector: " + vector2.add(vector1));
        System.out.println("minus vector: " + vector2.minus(vector1));
        System.out.println("dot vector: " + vector2.dot(vector1));
        vector2.insert(7, 0);
        vector2.insert(4, 1);
        System.out.println(vector2);
        int[] subspace = {2, 1};
        System.out.println("extract vector: " + vector2.extract(subspace));
    }

    public void doSimpleStatic() throws Exception {
        /* TODO */
        vectors = new MyVector[10];
        for (int i = 0; i < vectors.length - 2; i++) {
            if (i % 2 == 0) {
                vectors[i] = createRandomArrayVector();
            } else {
                vectors[i] = createRandomListVector();
            }
        }
        MyArrayVector vector9 = new MyArrayVector();
        MyArrayVector vector10 = new MyArrayVector();
        for (int i = 1; i <= 5; i++) {
            vector9.insert(i);
            vector10.insert(i);
        }
        vectors[8] = vector9;
        vectors[9] = vector10;
        System.out.println(Arrays.toString(vectors));
        System.out.println("norm max of all vectors: " + normMax());
        System.out.println("norm min of all vectors: " + normMin());
        System.out.println("Sorting vector by increasing norm: " + Arrays.toString(sortNorm(true)));
        System.out.println("Sorting vector by decreasing norm: " + Arrays.toString(sortNorm(false)));
        System.out.println("filtered vectors: " + Arrays.toString(filter(10, 20)));
        System.out.println("vectors rank: " + Arrays.toString(rank()));
    }

    /**
     * Lấy giá trị chuẩn lớn nhất trong các vector.
     *
     * @return chuẩn lớn nhất.
     */
    public double normMax() {
        /* TODO */
        double maxNorm = vectors[1].norm();
        for (MyVector vector : vectors) {
            if (maxNorm < vector.norm()) {
                maxNorm = vector.norm();
            }
        }
        return maxNorm;
    }

    /**
     * Lấy giá trị chuẩn nhỏ nhất trong các vector.
     *
     * @return chuẩn nhỏ nhất.
     */
    public double normMin() {
        /* TODO */
        double maxNorm = vectors[1].norm();
        for (MyVector vector : vectors) {
            if (maxNorm > vector.norm()) {
                maxNorm = vector.norm();
            }
        }
        return maxNorm;
    }

    /**
     * Lấy ra mảng các vector được sắp xếp theo thứ tự của chuẩn.
     * Nếu order là true thì mảng đầu ra là các vector có chuẩn tăng dần.
     * Nếu order là false thì mảng đầu ra là các vector có chuẩn giảm dần.
     *
     * @return mảng các vector theo thứ tự mảng tăng dần.
     */
    public MyVector[] sortNorm(boolean order) {
        /* TODO */
        List<MyVector> list = new ArrayList<>(List.of(vectors));
        list.sort(Comparator.comparingDouble(MyVector::norm));
        if (!order) {
            Collections.reverse(list);
        }
        MyVector[] result = list.toArray(new MyVector[0]);
        return result;
    }

    /**
     * Lọc ra mảng các vector có chuẩn năm trong đoạn [from, to].
     *
     * @param from
     * @param to
     * @return các vector có chuẩn nằm trong đoạn [from, to]
     */
    public MyVector[] filter(int from, int to) throws Exception {
        /* TODO */
        if (from >= to) {
            throw new Exception("Invalid value");
        }
        int dimension = vectors.length;
        MyVector[] myVectors = new MyVector[dimension];
        int count = 0;
        for (MyVector vector : vectors) {
            if (vector.norm() >= from && vector.norm() <= to) {
                myVectors[count] = vector;
                count++;
            }
        }
        MyVector[] result = Arrays.copyOf(myVectors, count);
        return result;
    }


    /**
     * Lấy ra thông tin rank của các vector trong mảng theo chuẩn.
     * Rank được tính theo quy luật sau, ví dụ
     * - tập [3 1 4] có rank [2.0 1.0 3.0]
     * - tập [3 1 3 5] có các rank [2.5 1.0 4.0] (các phần tử có giá trị bằng nhau có rank
     * được tính bằng trung bình các chỉ số của các phần tử trong tập dữ liệu, chỉ sổ bắt
     * đầu là 1)
     *
     * @return
     */
    public double[] rank() {
        /* TODO */
        int dimension = vectors.length;
        double[] vectorRank = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            int x = 1;
            int y = 1;
            for (int j = 0; j < dimension; j++) {
                if (j != i && vectors[j].norm() < vectors[i].norm()) {
                    x++;
                }
                if (j != i && vectors[j].norm() == vectors[i].norm()) {
                    y++;
                }
            }
            vectorRank[i] = x + (y - 1) / 2.0;
        }
        return vectorRank;
    }
}

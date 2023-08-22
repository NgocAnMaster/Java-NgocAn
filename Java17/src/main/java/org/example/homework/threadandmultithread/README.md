Cho n file text file1.txt, file2.txt, ... fileN.txt với nội dung mỗi file có nhiều dòng, mỗi dòng chứa 1 số tự nhiên. Ví
dụ:
file1.txt:
123
1
87122

file2.txt:
92
10
0
71

file3.txt: (Rỗng)

Danh sách các file được cho sẵn trong List<String> files = ["file1.txt", "file2.txt", "file3.txt"]

Yêu cầu: Viết chương trình Java tạo ra nhiều luồng để tính tổng các số trên từng dòng trong 1 file rồi đưa kết quả vào 1
list (không yêu cầu đúng thứ tự). Với ví dụ trên thì kết quả trả ra là:
List<Integer> sums = [87246, 173, 0] hoặc [87246, 0, 173] hoặc [0, 87246, 173] ...

Thực hiện yêu cầu trên lần lượt theo 3 cách sau:

1. Sử dụng Thread
2. Sử dụng CompletableFuture
3. Sử dụng parallelStream
Mô phỏng lại cơ chế hoạt động của một cơ sở dữ liệu (database)
1. Định nghĩa abstract class Record(Integer id, ZonedDateTime createdAt, ZonedDateTime updatedAt): đại diện cho 1 bản ghi trong database. Trường id là unique trong 1 bảng, createdAt: thời điểm bản ghi được insert vào database, updatedAt: thời điểm bản ghi được cập nhật gần nhất
2. Định nghĩa class Student(name, dob) kế thừa Record
3. Định nghĩa class School(name, address) kế thừa Record
4. Định nghĩa class Database, trong đó có thuộc tính records là 1 list chứa các bản ghi
5. Định nghĩa method save(record): Insert bản ghi mới nếu id chưa tồn tại hoặc thay thế bản ghi đã có nếu id đã tồn tại. Nếu đối tượng truyền vào ko có id thì tạo id kế sau id lớn nhất đang có trong records
6. Định nghĩa method find(int id): Tìm và trả ra bản ghi theo id, ko tìm thấy thì trả ra null
7. Định nghĩa method delete(int id): Xoá bản ghi theo id và trả ra bản ghi vừa bị xoá, ko tìm thấy thì trả ra null
8. Định nghĩa method findByCreatedAtAfter(ZonedDateTime time): Tìm các bản ghi có createdAt lớn hơn hoặc bằng time
9. Định nghĩa method findByUpdatedAtAfter(ZonedDateTime time): Tìm các bản ghi có updatedAt lớn hơn hoặc bằng time
10. Tạo hàm main() để test các method kể trên

Yêu cầu: Sử dụng generic ở vị trí phù hợp cho bài trên
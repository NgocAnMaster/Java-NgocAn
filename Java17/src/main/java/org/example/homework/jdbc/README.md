Cho file School.csv và Student.csv như trong file đính kèm. Yêu cầu:

Thực hiện trực tiếp trong database:
Tạo các bảng schools_<yourname> và students_<yourname> trong database PostgreSQL đã thực hành trên lớp (Ví dụ:
schools_khoivn và students_khoivn). Các bảng này cần chứa đủ các trường thông tin trong file CSV, tên trường để dạng
Snake case (ví dụ school_code) cộng thêm các trường created_at và updated_at (timestamp)
Lưu ý: Trường code trong Student và code trong School là unique

Thực hiện bằng code Java:

1. Định nghĩa các class Student và School (Trong đó bao gồm các field createdAt và updatedAt)
2. Viết hàm List<School> readSchools(String fileName) và List<Student> readStudents(String fileName) để đọc dữ liệu từ
   file School.csv và Student.csv, và trả ra List<School> và List<Student>
3. Viết hàm void insertStudents(List<Student> users) và void insertSchools(List<School> schools) sử dụng JDBC để
   insert dữ liệu từ các list ở trên vào database. Cập nhật giá trị created_at là thời điểm hiện tại
4. Đọc file Student update.csv vào List<Student> và viết hàm void updateStudents(List<Student> users) cập nhật dữ
   liệu này vào database, đồng thời cập nhật giá trị updated_at là thời điểm hiện tại
5. Viết hàm List<Student> để đưa ra danh sách các học sinh trên 18 tuổi (nếu ngày hôm nay 24/08/2023 thì cần sinh vào
   ngày 24/08/2005 hoặc trước đó)
6. (Nâng cao, rảnh thì làm) gộp chung hàm insertStudents và updateStudents vào 1 hàm insertOrUpdateStudents, trong đó
   chỉ sử dụng 1 câu query.

Thông tin kết nối:
Host: 4.194.217.58
Port: 5432
User: t2301e
Password: t2301e
Database: t2301e
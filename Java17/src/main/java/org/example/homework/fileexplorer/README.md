Viết chương trình mô phỏng phần mềm quản lý file trong máy tính:

Định nghĩa class FileExplorer với:

Các thuộc tính:

* Path path: Đường dẫn tới folder hiện tại. Khởi tạo giá trị là "C:" với Windows hoặc "/" với Mac / Linux

Các method:

* List<File> list(): Danh sách file/folder con của folder hiện tại
* String enter(String name): Với name là tên của 1 file / folder con của folder hiện tại
    * Nếu name là 1 file thì return nội dung của file
    * Nếu name là 1 folder thì di chuyển vào trong folder đó, return null
    * Nếu name ko tồn tại trong thư mục hiện tại thì throw RuntimeException "File/Folder not found"
* void createFile(String name, String content): Tạo file bên trong thư mục hiện tại với nội dung content
* void createFolder(String name): Tạo folder bên trong thư mục hiện tại
* void delete(String name): Xoá file hoặc folder con. Throw RuntimeException "File/Folder not found" nếu ko tồn tại
* void rename(String currentName, String newName): Đổi tên file hoặc folder con. Throw RuntimeException "File/Folder not
  found" nếu ko tồn tại
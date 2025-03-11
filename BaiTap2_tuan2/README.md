Hệ thống Quản lý Thư viện
➤ Tạo danh sách sách
➤ Tạo danh sách người dùng
➤ Cho phép người dùng mượn sách và hiển thị thông tin sách.
![image](https://github.com/user-attachments/assets/a5207f87-fded-4bd8-a922-3656c0e2c082)

**Mô Tả Cách Làm**
Ứng dụng sử dụng mutableStateListOf để lưu danh sách:
 employees → Lưu danh sách nhân viên
 books → Lưu danh sách sách
 borrowedBooks → Lưu danh sách nhân viên và sách đã mượn

Sử dụng remember { mutableStateOf() } để lưu trạng thái động của input (TextField) và checkbox.

3. Chức năng từng màn hình
 Quản lý mượn sách (ManagementScreen)
Chọn nhân viên từ Dropdown Menu.
Chọn sách bằng Checkbox.
Nhấn "Thêm" → Lưu thông tin vào borrowedBooks và hiển thị danh sách nhân viên đã mượn sách.
 Danh sách Sách (BookScreen)
Người dùng nhập tên sách vào TextField.
Nhấn "Thêm" → Thêm vào danh sách books.
Hiển thị danh sách sách trong LazyColumn.
 Danh sách Nhân viên (EmployeeScreen)
Người dùng nhập tên nhân viên vào TextField.
Nhấn "Thêm" → Thêm vào danh sách employees.
Hiển thị danh sách nhân viên trong LazyColumn.
4. UI & Thiết kế
OutlinedTextField → Nhập thông tin.
Button → Thêm dữ liệu.
LazyColumn → Hiển thị danh sách sách & nhân viên.
Card → Hiển thị danh sách nhân viên mượn sách.
DropdownMenu → Chọn nhân viên.
Checkbox → Chọn sách cần mượn.
5. Tóm tắt cách hoạt động
    Người dùng vào "Nhân viên", nhập tên nhân viên và nhấn "Thêm".
    Người dùng vào "DS Sách", nhập tên sách và nhấn "Thêm".
    Người dùng vào "Quản lý", chọn nhân viên, chọn sách và nhấn "Thêm" để lưu thông tin mượn sách.

**Kết quả đạt được**

![image](https://github.com/user-attachments/assets/0c4e41ac-dccf-47ea-9842-9df78f395abd)
![image](https://github.com/user-attachments/assets/d6f46306-35ea-49a8-8930-7e5b5f838eff)
![image](https://github.com/user-attachments/assets/02fe95ff-8337-42f4-80e3-565f451d081f)
![image](https://github.com/user-attachments/assets/199ee52f-940d-4f80-9239-82e75cedaf9b)
![image](https://github.com/user-attachments/assets/b66d9da6-3a2f-4eb7-994e-1fe7193d74e3)
![image](https://github.com/user-attachments/assets/44d600a2-6f47-4c5e-b8ff-53d3296d771b)







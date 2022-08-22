# spring-Data-JPA & React

## 啟動 React

在 vsCode 的終端機輸入以下：

    ```java!
        cd .\react-frontend\
        npm start
    ```

### Read

顯示全部 Users

![image](https://user-images.githubusercontent.com/107925706/185947867-c36fe8a1-3ee7-4bef-8ef8-4493ee422803.png)


### Create

新增 User 時，id 和 age 只能輸入數字，並且 id、name、age 不可以是 0 或 空值。  
送出後，接收 Service 的 response ，成功，顯示 response 的 state: OK；失敗，顯示response 的 state: FAIL。

![image](https://user-images.githubusercontent.com/107925706/185947979-b41d5f75-4f75-4531-8d62-da4b8f411658.png)
![image](https://user-images.githubusercontent.com/107925706/185948064-28692dfe-3ff3-4de9-8893-4bca31845391.png)

### Update

更新 User，只提供 name 和 age 的修改，並且 name、age 不可以是 0 或 空值。  
送出後，接收 Service 的 response ，成功，顯示 response 的 state: OK；失敗，顯示response 的 state: FAIL。

![image](https://user-images.githubusercontent.com/107925706/185952402-d1e9d8fd-bb72-4c45-b4b2-f3b245aeccac.png)
![image](https://user-images.githubusercontent.com/107925706/185948064-28692dfe-3ff3-4de9-8893-4bca31845391.png)

### Delete

按下 Delete，會有確定是否刪除的提示框，確定刪除，取消返回。

![image](https://user-images.githubusercontent.com/107925706/185952532-22948448-a15c-426f-9878-b6136b8ba367.png)


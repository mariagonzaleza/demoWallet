-------María A. González------------------------

Para probar la aplicación he utilizado Hal Browser. 
Para acceder: 
http://localhost:8080/

------Para crear wallets e ingresar dinero----------------------
URI --> http://localhost:8080/walletAccounts
HTTP METHOD --> POST
Espera datos en formato JSON, por ejemplo
{"userId": "Maria", "money": "555.55"}

----------------Consultar wallets-------------------------
http://localhost:8080/walletAccounts
GET
----------------Consultar Wallet por Id------------------
http://localhost:8080/walletAccounts/{id}
GET

----------Transacciones entre wallets--------------------
http://localhost:8080/transactions
HTTP METHOD --> POST
Espera datos en formato JSON, por ejemplo
{"sourceId": "1", "destId": "2" ,"money": "50.44"}

--Consultar histórico transacciones entre cuentas---------
http://localhost:8080/transactions 
GET

-----Se podrían implementar más funciones en la aplicación, para hacer la aplicación más completa.


# Struts-Demo-Project
A demo project showing struts, with boostrap and ajax call

![Immagine 2023-07-14 094739](https://github.com/lauda1994/Struts-Demo-Project/assets/128583812/1de75a1f-16e6-4d22-898f-2c89dbd74687)

This is a Java project using the (MVC) framework Struts1. It consists of a website where the admin user can log in. 

![videoScreenLogin](https://github.com/lauda1994/Struts-Demo-Project/assets/128583812/63c8206f-1c84-4f51-bfd2-0bea7f375e0f)

Once logged in, the user can choose various functionalities through the navbar, which are:

Insert Customer:
The admin user can insert a new record into the database (DB).

![insertForm](https://github.com/lauda1994/Struts-Demo-Project/assets/128583812/54f4d74a-6d21-4be2-bf93-6a6fee8ad6c1)

Modify Customer:
The user is presented with a search form where they can choose to search for a record by name and surname.
When the surname is selected, an AJAX call populates the select field with compatible names. 
Alternatively, the user can search by bank account code.
Once the search method is chosen and the record is selected,
a modification form appears with disabled fields. Clicking on the "Modifica" button enables the fields for modification. 
The form also includes a "Elimina" button that allows deleting the entire record.

![modForm](https://github.com/lauda1994/Struts-Demo-Project/assets/128583812/430b406e-ba2f-4651-8441-29d950fb56f2)

Customer List:
The user can view all the records present in the "anagraficacorrentisti" database.

![listCostumer](https://github.com/lauda1994/Struts-Demo-Project/assets/128583812/89241cba-7f58-4fcf-93a6-af9601c3bb1d)


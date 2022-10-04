# Course_Scheduler
A Java SQL Course Scheduler Project, It uses a local Apache Derby database to store database entries, as well as utilizing java swing GUI to create a replica of a professional Course Scheduler.

# Admin Features

Add Semester:
     A semester is added to the database. The semester is identified by one name. 
     
Add Course:
     A new course is added to the database. The course is identified by the semester it is 
to be added to, the code for the course, the description of the course and the maximum 
number of students the course will contain that semester. 

Add Student:
     A student is added to the database. The student is identified by a studentID, the 
student’s first name, and the student’s last name. 

Display Course List of Students:
     Display all the students who are scheduled or waitlisted for the specified course for 
the current semester. The scheduled students should be displayed first and then the 
waitlisted students in waitlist order. 

Drop Student:
     Remove the student from the list of students and remove them from any courses 
they are scheduled for in all semesters. For each course they were scheduled in, 
schedule the first student on the waitlist into the course. Display all of the changes that 
are made because of dropping the student. 

Drop Course:
     Remove the specified course from the current semester. Remove all students 
scheduled and waitlisted for the course from the Schedule Table. Display all of the 
changes that are made because of dropping the course. 

# Student Features

Schedule Course:
The student will be scheduled in the class for the specified semester, if there are 
seats available. If there are no seats available, the student will be put a wait list for that 
Course. The waiting list must be maintained in the order the students tried to schedule 
the course.  

Display Schedule:
The Display Schedule function will display the current schedule for a specified 
student for the current semester. 

Display Courses:
The Display Courses function will display a complete list of courses for the current 
semester. 

Drop Course: 
     Remove the specified course from the student’s schedule for the current semester. 
The student may be scheduled for the course or on the waitlist. Schedule the first 
student waiting for the course into the course. Display all of the changes that are made 
because of dropping the course. 

# Picture of GUI

![GUIpic1](https://user-images.githubusercontent.com/106610412/193871815-16182b18-e5b8-47fc-be33-b80f4e218af1.PNG)

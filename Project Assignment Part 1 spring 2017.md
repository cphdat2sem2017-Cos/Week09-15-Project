­
# Project Assignment 2 semester Spring 2017
# Part 1 of 2
# The task

Working in groups and using Scrum as the process model, you must develop major parts of a multi-user database application.

The project constitutes the formal basis for the exam on 2nd semester. It is divided into a longer Part 1 and a shorter Part 2.

This document presents Part 1.

The constraints on your work during Part 1 can be summarized in a set of requirements regarding:

1. what you have to develop (the product)
2. how you have to work (the process)
3. what you must hand in or demonstrate (the documentation).

# Product requirements

The case you work with is the Fog-case, which was presented by Fog, and used as case in classes week 11 & 12. Some of the artefacts you  developed in week 11 will go into the report. Further documentation can be found in the project folder on github.

You must develop and (partly) test a system that meets (parts of) the needs of the customer.

Note that the requirements may be subject to changes and "clarifications" during the project period.

The solution must respect the following set of technical and design related constraints:

1. It must use a MySQL 5.7 database.
2. The design must reflect a logical multilayer architecture running on a Java server (Tomcat).
3. Your application must use both plain java classes, servlets and JSP's.
4. The web page must be usable in either Chrome or Firefox.
5. The developed application must be deployed in the cloud (e.g. digital ocean).
6. The source code must be available in a github repository.

# Process requirements – in short

Part 1 covers 4 Scrum sprints (each sprint ranging from 2-3 weeks). Planning these sprints must be done according to the guidelines in Scrum. You are the Scrum Team and the teachers will act as Product Owner, but you will be responsible for identifying and writing the stories **.** Note that days are set aside in the end of the project period to finish the **report** part 1.

At the end of each sprint, a sprint review will be held where you must prepare a demo of the stories implemented by the group during the sprint.  Also, there will be a technical review of your implementation.

During the project period you can get ad hoc guidance from the teachers. A teacher will be present at school at all project days­. It is the responsibility of the group to seek the teachers' advice whenever a need arises during the project period.

# Documentation requirements – in short

A number of sprint meetings with the teachers will be scheduled during the project.  At these meetings each group must bring a number of artifacts. See details in the section "Sprint Meetings" below.

The final project delivery includes:

  -  An exam report        (text - to be handed in on wiseflow)
  -  A product             (program - to be made available on your github)

The exam report must document the final product as well as the process leading to it.

It must be explicitly stated which group members are responsible for each of the different parts of the final delivery to enable individual assessment. The final delivery of Part 1 will become the major part of the assessment base for the exam. More details about the documentation requirements as well as the assessment criteria and assessment procedures can be found below.

# About achieving academic goals while working on a project

Working on a project is considered a way of learning in line with conducting regular class sessions and exercises. This implies that you are expected to acquire a certain amount of new knowledge and experience regarding central topics of the 2nd semester through your personal commitment and effort during the project.

There is no final list of solutions for this type of task. Hence, do expect problems to arise to which the teachers don't have a "quick solution". In these situations, you are encouraged to work systematically and follow the steps:

-  Clarify the problem
-  Identify alternative solutions
-  Estimate advantages / disadvantages
-  Choose a solution
-  Briefly document arguments

# Sprint Meetings

A number of Scrum meetings must be held during the project period. They are described below.

**Sprint Planning and Review Meetings**

At the start of each sprint we will hold a combined &quot;Sprint Planning and Review Meeting with each team. A teacher will participate and act as &quot;Product Owner&quot;. 

The group must bring the following artifacts to the meetings

1. Product Backlog \*)
2. Sprint Backlog
3. Program (demo of implemented user stories)

The outcome and decisions from these meetings should be documented (process report)

_\*) Because it is a school project, the team is responsible for making and updating the Product Backlog (stories, story points, how to demo descriptions). This is normally done by the Product owner._

**Sprint Retrospective Meetings**

The team holds its own "Retrospective Meeting" after each Sprint review meeting with the Product Owner in order to identify any possible improvements with regards to people, relationships, process and tools for the next sprint.

The outcome and decisions from these meetings should be documented (process report)

**Daily Scrum Meeting**

Teams are expected to do daily Scrum meetings (max 15 min) reporting to each other.

The outcome and decisions from these meetings should be documented (process report).

# Technical Review meetings

Each team holds two meetings where technical artifacts are reviewed. A teacher will participate and act as &quot;Technically proficient Product Owner&quot;. 

The group must bring the following artifacts to the meetings

1. Updated Domain Model         (only at first technical review meeting)
2. E/R-diagram                  (only at first technical review meeting)
3. Source code
3. Test cases

# Final Delivery (Exam Report and Product):

The delivery must as a minimum contain the following artifacts:

## Product Report
  -  Business Case (Vision and Goal for the IT-system, Traceability model, Activity diagram and Domain Model)
  -  Product Backlog (User Stories)
  -  Architecture Model (high level design)
  -  Design Class Diagram (DCD)
  -  Sequence Diagram(s) (SD's)  covering at least one core or complex scenario
  -  Description of the qualities of your design (coupling, cohesion, the use of patterns etc.)
  -  E/R diagram - including assessment of compliance with normal forms
  -  Description of the most complex parts of the code
  -  Descriptions of complex or core SQL queries and updates
  -  SQL scripts (appendix)
  -  Screen dumps of UI (2-4 selected)
  -  Documentation of all test activities performed
  -  Documentation of an automated test (JUnit) of minimum one class in the data source layer.
  -  Conclusion – including a short overview of which parts of the complete set of requirements that have been implemented.
  -  Link to your server running the program

    **OBS!** For each diagram in the report**, you must provide a description of:
	- The context or purpose of the diagram
	- Any non-trivial information necessary to interpret the model correctly
	- Any core development decisions illustrated by the diagram

## Executable software
  -  A NetBeans project  supplemented by all additional files needed for running the program should be on the groups GitHub.
  -  URL to the group's GitHub repository
  -  List of how GitHub aliases map to group members

## Process Report
  -  Sprint Backlog for each sprint
  -  Retrospective documentation from each sprint
  -  Assessment of group co-operation and use of roles
  -  Assessment of the usefulness of methods, tools and techniques applied during the project
  -  Conclusion

## Formalities

The front page must contain class name, group number and name of each group member as well as hand-in date.

It must be clearly stated which member of the group is responsible for which part of the report and program.

The reports must not exceed 60 standard pages (each of 2.400 characters). This limit applies to the combined volume of the final delivery from part 1 and part 2 (excluding code and appendices). It is recommended to reserve 50 pages to the first part, and 10 pages to the second part.

## Assessment Procedure (exam)

The final delivery must be handed in electronically through WiseFlow exam system (information will be specified in later).

Use the following format for the name of the file: "**group\_NN\_2semX**" (replace NN with your group number, and X with class – ex:  "group\_01\_2semB").

To the individual exam each student must bring a PC and be able to connect it to the monitor cable in the classroom.

Each student will be given a mark that reflects the combined assessment of the final deliveries from Part 1 and 2, the group presentation and the individual examination.

# Hand-in part 1

Date: Monday May 29th 2017 at 16:00 using Wiseflow.

# Hand-in part 2

Date: Sunday April 30th 2017 at 23.59 using Wiseflow.

# Assessment criteria

#### _A good report – does the following:_

-  Documents the product so that it enables the reader to understand
  -  the business value i.e. the reason for developing the system
  -  the implementation of the system in order to be able to finish and maintain it
  -  the rationale behind core decisions made during the development
  -  how to Install and use the system (what is the URL, where to change the connection to the database if necessary etc.)

-  Documents the process so that it enables the reader to recall
  -  Project settings and scope
  -  Plans
  -  Course of events
  -  Reflections

#### _A good report – has the following qualities:_

-  Is complete (contains all the artifact required)
-  Is easy to read and understand.
-  Uses appropriate technical / professional language and diagrams
-  Preserve traceability between models (models are mutually consistent and coherent  - from detailed requirements to executable code)
-  Describes relevant problems and arguments for choices made.

#### _A good system_

-  implements many functional requirements (but a full system is not expected)
-  is easy to understand, complete, maintain, expand and reuse.
-  uses naming conventions and is properly commented (Java code)
-  bserves current design guidelines (patterns)
-  ensures data consistency in the database

# Meetings

Each team must participate in Sprint meetings with "Product Owner" and in the technical reviews. 

Schedule for these meetings will appear in the [the semesterplan](https://docs.google.com/spreadsheets/d/1FwMORE15AfUhyyNh_7Ytno9r5t7XntRaOLWmzyj0Cbw/edit#gid=0).
 

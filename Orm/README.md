# JPA, Spring Data Test

## Overview
Application contains entity model that stores students data and theirs subjects scores

### Expected tables to be generated:
* table students (id bigint not null, name varchar(255), surname varchar(255), primary key (id))
* table subjects (id bigint not null, final_score numeric(38,2), name varchar(255), student_id bigint, primary key (id))
## Task:
* Make sure that only expected table are generated
* Fix app the code to pass tests
* Do not change test code

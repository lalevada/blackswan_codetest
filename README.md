# Coding test project for Blackswan

This application is used to mock bank link to wallet functionality for banks to dev against.

## Endpoints

### POST {baseurl}/api/user

This operation creates a user.
 
### PUT {baseurl}/api/user/{id}
 
 This operation updates a user.

### GET {baseurl}/api/user/{id}
 
 This operation fetches a user.

### GET {baseurl}/api/user
 
 This operation fetches a list of all users.

### POST {baseurl}/api/user/{user_id}/task
 
 This operation adds a task to a user.

### PUT {baseurl}/api/user/{user_id}/task/{task_id}
 
 This operation updates a task for a user.

### DELETE {baseurl}/api/user/{user_id}/task/{task_id}
 
 This operation deletes a user task.

### GET {baseurl}/api/user/{user_id}/task/{task_id}
 
 This operation gets a user task.

### GET {baseurl}/api/user/{user_id}/task
 
 This operation gets all tasks for a user.

## Change Log

### 1.0.0

Initial release.


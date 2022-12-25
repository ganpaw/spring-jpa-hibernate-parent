![Alt text](many-to-one-uni.png?raw=true "Title")

````
Tutorial endpoints:

Methods	Urls	Actions				Description
POST			/api/tutorials			Add new tutorial
GET				/api/tutorials			Get all tutorials or tutorials containing title if passed a request parameter (optional)
GET				/api/tutorials/:id   	Get tutorial by id
PUT				/api/tutorials/:id 		Update tutorial by id
DELETE			/api/tutorials/:id 		Delete tutorial (and its comments) by :id
DELETE			/api/tutorials			Delete all tutorials (and their comments) - should clean up both tutorial and comments tables

Comment endpoints:

Methods	Urls	Actions							Description
POST			/api/tutorials/:id/comments				Add new comment by tutorial id - 1. retrieve tutorial by id, 2. comment.setTutorial(tutorial) 3. save comment
GET				/api/tutorials/:id/comments				Get all comment fo a tutorial - if tutorial doesn't exist throw error else Get comment by tutorial id.
GET				/api/comments/:id 				Get comment by comment id
PUT				/api/comments/:id 				Update comment by comment id
DELETE			/api/comments/:id 				Delete comment by comment id
DELETE			/api/tutorials/:id/comments			Delete all comments of a tutorial
````

### Tutorial endpoints:
Add new tutorial in 3 separate requests
````
POST http://localhost:8080/api/tutorials
{
    "title": "Java tutorial in 100 minutes"
}
POST http://localhost:8080/api/tutorials
{
    "title": "Python tutorial in 50 minutes"
}
POST http://localhost:8080/api/tutorials
{
    "title": "Spring tutorial in 60 minutes"
}
````
Get all tutorials or tutorials containing title if passed a request parameter (optional)optional)
````
GET http://localhost:8080/api/tutorials
GET http://localhost:8080/api/tutorials?title=Spring tutorial in 60 minutes
````
Get tutorial by id
````
GET http://localhost:8080/api/tutorials/2
````
Update tutorial by id
````
PUT http://localhost:8080/api/tutorials/2
{
    "title": "Python tutorial in 2 weeks"
}
````
Delete tutorial (and its comments) by :id - Try this request after you add few comments
````
GET http://localhost:8080/api/tutorials/2 - will show tutorial
GET http://localhost:8080/api/tutorials/2/comments -  will show its comment
DELETE http://localhost:8080/api/tutorials/2 - delete tutorial which will also cascade delete comments table rows
GET http://localhost:8080/api/tutorials/2 - no tutorial found
GET http://localhost:8080/api/tutorials/2/comments - no comments found
````
Delete all tutorials (and their comments) - should clean up both tutorial and comments tables -  Try this request after you add few comments
````
DELETE http://localhost:8080/api/tutorials
````

### Comments endpoints:
Add new comment by tutorial id - 1. retrieve tutorial by id, 2. comment.setTutorial(tutorial) 3. save comment
````
POST http://localhost:8080/api/tutorials/1/comments
{
    "comment": "A great java tutorial"
}
POST http://localhost:8080/api/tutorials/1/comments
{
    "comment": "Best tutorial on Java"
}
POST http://localhost:8080/api/tutorials/2/comments
{
    "comment": "Good start tutorial for Python language"
}
POST http://localhost:8080/api/tutorials/3/comments
{
    "comment": "Deep understanding tutorial on Spring"
}
POST http://localhost:8080/api/tutorials/3/comments
{
    "comment": "Start to Advanced tutorial on Spring"
}
````
Get all comment fo a tutorial - if tutorial doesn't exist throw error else Get comment by tutorial id.
````
GET http://localhost:8080/api/tutorials/1/comments
GET http://localhost:8080/api/tutorials/2/comments
GET http://localhost:8080/api/tutorials/3/comments
````
Update comment by comment id
````
GET http://localhost:8080/api/comments/2
PUT http://localhost:8080/api/comments/2
{
    "comment": "5 star tutorial on Java"
}
GET http://localhost:8080/api/comments/3
GET http://localhost:8080/api/tutorials/1/comments
````
Delete comment by comment id
````
DELETE http://localhost:8080/api/comments/3
Status: 204
````
Delete all comments of a tutorial
````
DELETE http://localhost:8080/api/tutorials/1/comments
Status: 204
````

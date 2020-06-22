curl -I http://127.0.0.1:8080/
curl -I http://127.0.0.1:8080/users

curl -H "Content-Type: application/json" -X POST -d '{"username":"admin","password":"123456"}' http://127.0.0.1:8080/login
{"result":"eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4sQVVUSF9XUklURSIsInN1YiI6ImFkbWluIiwiZXhwIjoxNTkyOTg4MDM3fQ.-08hMf46y05VQ1aYgMhAhtjMUSGnox11N3Pp1O1gR3pSfj4cMLyHlsFaexGUkd7n3yGVXtsT-lrtXaz9V3fj9w","message":"","status":0}

curl -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4sQVVUSF9XUklURSIsInN1YiI6ImFkbWluIiwiZXhwIjoxNTkyOTg4MDM3fQ.-08hMf46y05VQ1aYgMhAhtjMUSGnox11N3Pp1O1gR3pSfj4cMLyHlsFaexGUkd7n3yGVXtsT-lrtXaz9V3fj9w"  http://127.0.0.1:8080/users
{"result":["fufeng","lcy","jerry"],"message":"成功","status":200}















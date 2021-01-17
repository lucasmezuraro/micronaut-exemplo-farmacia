import time
from locust import HttpUser, task

class QuickstartUser(HttpUser):

    HttpUser.host = "http://172.21.109.235:30546"


    @task
    def hello_world(self):
        self.client.get("/")


















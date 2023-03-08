from django.db import models


class ActivityLog(models.Model):
   # id          = models.IntegerField(primary_key=True)
    operation   = models.CharField(max_length=200)
    macaddress  = models.CharField(max_length=100)
    ipaddress   = models.CharField(max_length=20)
    browser     = models.CharField(max_length=50)
    username    = models.CharField(max_length=20)
    #createdAt  = models.DateTimeField(auto_now_add=True)
    
    
    
    
    
    
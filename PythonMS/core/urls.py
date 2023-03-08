from django.urls import path
from .views import ActivityLoggerAPIView
urlpatterns = [
 path('acts',ActivityLoggerAPIView.as_view())
]

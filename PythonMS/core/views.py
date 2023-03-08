from rest_framework.views import APIView
from .models import ActivityLog
from .serializers import ActivityLoggerSerializer
from rest_framework.response import Response
class ActivityLoggerAPIView(APIView):
    def get(self, request):
        acts = ActivityLog.objects.all()
        serializers = ActivityLoggerSerializer(acts, many=True)
        return Response(serializers.data())
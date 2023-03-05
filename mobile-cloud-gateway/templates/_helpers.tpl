{{- define "jio.service.url" -}}
{{ (printf "http://%s:%v" .Values.jio.name .Values.jio.hostPort ) | default "http://jio-service:9501" }}
{{- end -}}

{{- define "jio.service.id" -}}
{{ (printf "%s" .Values.jio.name ) | default "jio-service" }}
{{- end -}}

{{- define "jio.service.path" -}}
{{ (printf "Path= %s" .Values.jio.path ) | default "Path= /jio/*" }}
{{- end -}}

{{- define "airtel.service.url" -}}
{{ (printf "http://%s:%v" .Values.airtel.name .Values.airtel.hostPort ) | default "http://airtel-service:9501" }}
{{- end -}}

{{- define "airtel.service.id" -}}
{{ (printf "%s" .Values.airtel.name ) | default "airtel-service" }}
{{- end -}}

{{- define "airtel.service.path" -}}
{{ (printf "Path= %s" .Values.airtel.path ) | default "Path= /airtel/*" }}
{{- end -}}

{{- define "vodaphone.service.url" -}}
{{ (printf "http://%s:%v" .Values.vodaphone.name .Values.vodaphone.hostPort ) | default "http://vodaphone-service:9501" }}
{{- end -}}

{{- define "vodaphone.service.id" -}}
{{ (printf "%s" .Values.vodaphone.name ) | default "vodaphone-service" }}
{{- end -}}

{{- define "vodaphone.service.path" -}}
{{ (printf "Path= %s" .Values.vodaphone.path ) | default "Path= /vodaphone/*" }}
{{- end -}}

{{- define "frontend.nodeport.name" -}}
{{ (printf "%s-nodeport" .Values.frontend.name ) | default "frontend-service-nodeport" }}
{{- end -}}
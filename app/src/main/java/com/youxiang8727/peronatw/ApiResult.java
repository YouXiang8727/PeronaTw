package com.youxiang8727.peronatw;

import java.io.Serializable;
import java.util.List;

public class ApiResult implements Serializable {
    private String success;
    private Result result;
    private Records records;

    public String getSuccess() {
        return success;
    }

    public Result getResult() {
        return result;
    }

    public Records getRecords() {
        return records;
    }

    public static class Result implements Serializable{
        private String resource_id;
        private List<Field> fields;

        public String getResource_id() {
            return resource_id;
        }

        public List<Field> getFields() {
            return fields;
        }

        public static class Field implements Serializable{
            private String id;
            private String type;

            public String getId() {
                return id;
            }

            public String getType() {
                return type;
            }
        }
    }

    public static class Records implements Serializable{
        private String datasetDescription;
        private List<Location> location;

        public String getDatasetDescription() {
            return datasetDescription;
        }

        public List<Location> getLocation() {
            return location;
        }

        public static class Location implements Serializable{
            private String locationName;
            private List<WeatherElement> weatherElement;

            public String getLocationName() {
                return locationName;
            }

            public List<WeatherElement> getWeatherElement() {
                return weatherElement;
            }

            public static class WeatherElement implements Serializable{
                private String elementName;
                private List<Time> time;

                public String getElementName() {
                    return elementName;
                }

                public void setElementName(String elementName) {
                    this.elementName = elementName;
                }

                public List<Time> getTime() {
                    return time;
                }

                public void setTime(List<Time> time) {
                    this.time = time;
                }

                public static class Time implements Serializable{
                    private String startTime;
                    private String endTime;
                    private Parameter parameter;

                    public String getStartTime() {
                        return startTime;
                    }

                    public String getEndTime() {
                        return endTime;
                    }

                    public Parameter getParameter() {
                        return parameter;
                    }

                    public static class Parameter implements Serializable{
                        private String parameterName;
                        private String parameterValue;

                        public String getParameterName() {
                            return parameterName;
                        }

                        public String getParameterValue() {
                            return parameterValue;
                        }
                    }
                }
            }
        }
    }
}
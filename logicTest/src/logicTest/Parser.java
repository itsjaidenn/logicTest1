package logicTest;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.json.*;



public class Parser {
	
	//Parse the actual JSON
	
	Map<String, Job> jobs;
	List<Employee> employees;
	
	public Parser() {

		String jsonString =jsonRaw();
		this.jobs = new HashMap<>();
		this.employees = new ArrayList<>();
				
		
		JSONObject obj = new JSONObject(jsonString);
	
		JSONArray arr = obj.getJSONArray("jobMeta");
		for (int i = 0; i < arr.length(); i++)
		{
			String job_name = arr.getJSONObject(i).getString("job");
			double rate = arr.getJSONObject(i).getDouble("rate");
			double benefitsRate = arr.getJSONObject(i).getDouble("benefitsRate");
			this.jobs.put(job_name, new Job(job_name,rate,benefitsRate));
	    
			
		}

		JSONArray arr2 = obj.getJSONArray("employeeData"); 
		for (int i = 0; i < arr2.length(); i++)
		{
			String employee = arr2.getJSONObject(i).getString("employee");
			JSONArray arr3 = arr2.getJSONObject(i).getJSONArray("timePunch");
			List<TimePunch> timepunches = new ArrayList<>();
			
			for (int j = 0; j < arr3.length(); j++) {
				String job = arr3.getJSONObject(j).getString("job");
				String start = arr3.getJSONObject(j).getString("start");
				String end = arr3.getJSONObject(j).getString("end");
				timepunches.add(new TimePunch(job, start, end));
			}
			this.employees.add(new Employee(employee, timepunches));
			
		}
	}
	
	public Map<String, Job> jobs() {
		return this.jobs;
	}
	
	public List<Employee> employees(){
		return this.employees;
	}
	
	
	//I chose to use the jSON raw but obviously in a real use case we would pull from a file, query, or webservice request
	
	public String jsonRaw(){
		
		String jsonRaw = "{\r\n"
				+ "  \"jobMeta\": [\r\n"
				+ "    {\r\n"
				+ "      \"job\": \"Hospital - Painter\",\r\n"
				+ "      \"rate\": 31.25,\r\n"
				+ "      \"benefitsRate\": 1\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"job\": \"Hospital - Laborer\",\r\n"
				+ "      \"rate\": 20,\r\n"
				+ "      \"benefitsRate\": 0.5\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"job\": \"Shop - Laborer\",\r\n"
				+ "      \"rate\": 16.25,\r\n"
				+ "      \"benefitsRate\": 1.25\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"employeeData\": [\r\n"
				+ "    {\r\n"
				+ "      \"employee\": \"Mike\",\r\n"
				+ "      \"timePunch\": [\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-18 09:00:01\",\r\n"
				+ "          \"end\": \"2022-02-18 11:28:54\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-18 12:29:33\",\r\n"
				+ "          \"end\": \"2022-02-18 14:00:59\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-19 08:16:51\",\r\n"
				+ "          \"end\": \"2022-02-19 10:00:11\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-19 11:11:06\",\r\n"
				+ "          \"end\": \"2022-02-19 12:00:14\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-19 13:22:13\",\r\n"
				+ "          \"end\": \"2022-02-19 17:16:32\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-20 06:50:12\",\r\n"
				+ "          \"end\": \"2022-02-20 11:21:11\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-20 13:01:11\",\r\n"
				+ "          \"end\": \"2022-02-20 17:52:45\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-21 07:08:11\",\r\n"
				+ "          \"end\": \"2022-02-21 12:22:33\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-21 13:15:10\",\r\n"
				+ "          \"end\": \"2022-02-21 17:58:06\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-22 07:11:59\",\r\n"
				+ "          \"end\": \"2022-02-22 11:00:01\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-22 12:16:54\",\r\n"
				+ "          \"end\": \"2022-02-22 17:59:03\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"employee\": \"Steve\",\r\n"
				+ "      \"timePunch\": [\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-18 06:02:35\",\r\n"
				+ "          \"end\": \"2022-02-18 11:28:54\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-18 12:31:06\",\r\n"
				+ "          \"end\": \"2022-02-18 15:00:11\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-19 07:03:41\",\r\n"
				+ "          \"end\": \"2022-02-19 10:00:45\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-19 10:24:58\",\r\n"
				+ "          \"end\": \"2022-02-19 12:00:19\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-19 13:22:13\",\r\n"
				+ "          \"end\": \"2022-02-19 17:16:32\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-20 05:56:00\",\r\n"
				+ "          \"end\": \"2022-02-20 11:33:23\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-20 12:18:45\",\r\n"
				+ "          \"end\": \"2022-02-20 17:48:41\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-21 06:02:28\",\r\n"
				+ "          \"end\": \"2022-02-21 12:22:19\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-21 13:04:01\",\r\n"
				+ "          \"end\": \"2022-02-21 17:52:06\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-22 06:00:58\",\r\n"
				+ "          \"end\": \"2022-02-22 11:02:55\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Painter\",\r\n"
				+ "          \"start\": \"2022-02-22 12:18:04\",\r\n"
				+ "          \"end\": \"2022-02-22 17:48:41\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"employee\": \"Alex\",\r\n"
				+ "      \"timePunch\": [\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-18 06:05:55\",\r\n"
				+ "          \"end\": \"2022-02-18 11:18:14\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-18 11:30:09\",\r\n"
				+ "          \"end\": \"2022-02-18 14:00:01\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-19 07:18:22\",\r\n"
				+ "          \"end\": \"2022-02-19 11:07:45\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-19 12:04:18\",\r\n"
				+ "          \"end\": \"2022-02-19 14:00:19\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-20 06:06:00\",\r\n"
				+ "          \"end\": \"2022-02-20 10:13:23\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-20 12:18:45\",\r\n"
				+ "          \"end\": \"2022-02-20 16:58:21\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-21 06:08:08\",\r\n"
				+ "          \"end\": \"2022-02-21 12:20:55\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Shop - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-21 12:54:30\",\r\n"
				+ "          \"end\": \"2022-02-21 16:45:20\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-22 06:09:14\",\r\n"
				+ "          \"end\": \"2022-02-22 11:30:11\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"job\": \"Hospital - Laborer\",\r\n"
				+ "          \"start\": \"2022-02-22 12:00:29\",\r\n"
				+ "          \"end\": \"2022-02-22 17:59:55\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		return jsonRaw;
	}

}

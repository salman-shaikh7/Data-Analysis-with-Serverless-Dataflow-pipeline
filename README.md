# Google Cloud Dataflow Pipeline (Python) 2.5

## Overview

Google Cloud Dataflow is a fully managed service for stream and batch data processing. It allows you to build scalable, distributed data processing pipelines. Dataflow is commonly used for real-time analytics, and more, particularly with Apache Beam as the underlying programming model.

In this project we will

1.  Open Dataflow project
2.  Pipeline filtering
3.  Execute the pipeline locally and on the cloud

## Objective

* Setup a Python Dataflow project using Apache Beam.
* Write a simple pipeline in Python.
* Execute the query on the local machine.
* Execute the query on the cloud.


## TASK 1 : SetUp

### Step 1: Authectication login

```bash
gcloud auth list
```
```bash
gcloud auth login
```
### Step 2: Setting up project
```
gcloud config get-value project

gcloud config set project myprojectid7028
```

## TASK 2 :  Enabling Dataflow API.

Code

```bash 
gcloud services disable dataflow.googleapis.com --force
gcloud services enable dataflow.googleapis.com
```


## TASK 3 :  Preparation

For this project we will use cloud shell machine as local machine.

### STEP 1 : Clone git repo

```bash
git clone https://github.com/GoogleCloudPlatform/training-data-analyst
```

### STEP 2 : Create a bucket 

```bash
gcloud storage buckets create gs://myprojectid7028 --location=us-east1 --no-public-access-prevention
```

### STEP 3 : Setting up Bucket name 

```bash
BUCKET="myprojectid7028"
echo $BUCKET
```


## TASK 4 : Pipeline filtering 

```python
pip install apache-beam
```





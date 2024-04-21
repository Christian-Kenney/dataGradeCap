#!/bin/bash

# Build frontend
echo "Building frontend..."
cd Frontend
npm install
npm run build
cd ..

# Copy frontend build to backend directory
echo "Copying frontend build to backend directory..."
rm -rf dataGrade/src/main/resources/static/*
cp -r Frontend/build/* dataGrade/src/main/resources/static/

# Build backend
echo "Building backend..."
cd dataGrade
./mvnw clean package
cd ..

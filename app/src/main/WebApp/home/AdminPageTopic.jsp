<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="windows-1256">
<title>Speak</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js" integrity="sha512-dqw6X88iGgZlTsONxZK9ePmJEFrmHwpuMrsUChjAw1mRUhUITE5QU9pkcSox+ynfLhL15Sv2al5A0LVyDCmtUw==" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" integrity="sha512-8bHTC73gkZ7rZ7vpqUQThUDhqcNFyYi2xgDgPDHc+GXVGHXq+xPjynxIopALmOPqzo9JZj0k6OqqewdGO3EsrQ==" crossorigin="anonymous" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="http://www.arabic-keyboard.org/keyboard/keyboard.css"> 
<script type="text/javascript" src="http://www.arabic-keyboard.org/keyboard/keyboard.js" charset="UTF-8"></script> 


</head>
<body  style="background-image: url('cc.jpg');background-repeat:round;background-attachment: fixed; ;">
<nav class="navbar   fixed-top" style="background-color:white;  ">

  <img src="logo.jpg" class="ui center medium image" alt="...">

  

 
   <!-- Example single danger button -->
<div class="btn-group navbar-brand">
 

<div class="dropdown">
  <button class="btn  dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    More
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="/Logout">Logout</a>
    <a class="dropdown-item" href="/Adminlanguage"><i class="world icon"></i>${language == "Fr" ? 'Ar' : 'Fr' }</a>
  </div>
</div>
 
  
 </div>
</nav><br><br><br><br><br><br><br><br><br>



<br>
<div class="ui link centered cards" style="width: 74%;float: left;">

  <c:forEach items="${fields }" var="field">
  <div class="ui card shadow-lg p-3 mb-5 bg-white rounded" style=" background-repeat: no-repeat; background-position: center;background-image: url('<c:out value="${field.fieldImg }" />'); " >
  <a class="image" >
  </a>
  
  <div class="content "style="background-color: black;opacity: 0.7">
    <p style="color: white;" class="header float-left"><c:out value="${field.fieldName }" /></p>
    <p style="color: white;"class="header float-right"><c:out value="${language == 'Fr' ? field.fieldNameFrancais : field.fieldNameArabe }" /> 
  <hr>
  <div class="d-flex justify-content-center">
  <form action="/AdmingetField" method="get">
  <input type="hidden" name="fieldName" value='<c:out value="${field.fieldName }"/>'>
  <div style="float: left;">
    <button type="submit" class="info circular button ui icon"><i class="eye icon"></i></button>  
  </div>
  </form>
  <form action="/AdmindeleteWord" method="get">
  <input type="hidden" name="fieldName" value='<c:out value="${field.fieldName }"/>'>
  <input type="hidden" name="fieldImg" value='<c:out value="${field.fieldImg }"/>'>
  <div style="float: right;;">
    <button type="submit" class="negative circular button ui icon"><i class="trash alternate outline icon"></i></button>
      
  </div>
  </form>
  </div>
  </div>
  </div>
  
  </c:forEach>
  
 
  
</div>

<div class="ui medium form shadow-lg p-3 mb-5 bg-white rounded" style="width: 24%;float: right;">
<form action="/AdminaddField" method="post" enctype="multipart/form-data" style="margin-right: 10%">
  
    <div class="field">
      <label>Field Name</label>
      <input type="text" name="fieldName">
    </div>
    <div class="field">
      <label>Field Frensh Name</label>
      <input type="text" name="fieldNameFrancais">
    </div>
 
  
    <div class="field">
      <label>Field Arabic Name</label>
      <input type="text" dir="rtl" class="keyboardInput" name="fieldNameArabe">
    </div>
    <div class="field">
      <label>Field Image</label>
      <input type="file" name="fieldImg">
      <input type="hidden" name="topicName" value='<c:out value="${topicChoix }"></c:out>'>
    </div>
  	<div class="field">
  <button class="positive fluid ui submit button" type="submit"><i class="plus icon"></i></button>
  </div>
  </form>
  </div>






<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
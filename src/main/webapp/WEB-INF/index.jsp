<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Games and Genres</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<h1>Games and Genres</h1>
		
		<div class="row">
			<div class="col-sm-6">
				<form:form action="/games" method="post" modelAttribute="newGame">
					<div class="form-group">
						<label>Title</label>
						<form:input path="title" class="form-control" />
						<form:errors path="title" class="text-danger" />
					</div>
					
					<div class="form-group">
						<label>Studio</label>
						<form:input path="studio" class="form-control" />
						<form:errors path="studio" class="text-danger" />
					</div>
					
					<div class="form-group">
						<label>Year</label>
						<form:input path="year" class="form-control" />
						<form:errors path="year" class="text-danger" />
					</div>
					
					<input type="submit" value="Add Game" class="btn btn-primary" />
				</form:form>
			</div>
			
			<div class="col-sm-6">
				<form:form action="/genres" method="post" modelAttribute="newGenre">
					<div class="form-group">
						<label>Genre Name</label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>
					
					<input type="submit" value="Add Genre" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<table class="table">
					<tr>
						<th>Title</th>
						<th>Studio</th>
						<th>Year</th>
						<th>Genres</th>
					</tr>
					<c:forEach items="${allGames}" var="game">
						<tr>
							<td>${game.title}</td>
							<td>${game.studio}</td>
							<td>${game.year}</td>
							<td>${game.genreDescription()}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-sm-6">
				<form action="/addGenreToGame" method="post">
					<div class="form-group">
						<label>Game</label>
						<select name="game_id" class="form-control">
							<c:forEach items="${allGames}" var="game">
								<option value="${game.id}">${game.title} (${game.year})</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label>Genre</label>
						<select name="genre_id" class="form-control">
							<c:forEach items="${allGenres}" var="genre">
								<option value="${genre.id}">${genre.id} ${genre.name}</option>
							</c:forEach>
						</select>
					</div>
					
					<input type="submit" value="Add Genre to Game" class="btn btn-primary" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>